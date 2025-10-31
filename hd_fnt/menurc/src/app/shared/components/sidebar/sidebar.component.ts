import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterLink, RouterLinkActive } from '@angular/router';
import { AuthService } from '../../../core/services/auth.service';

@Component({
  selector: 'app-sidebar',
  standalone: true,
  imports: [RouterLink,RouterLinkActive,FormsModule,CommonModule],
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.css'
})
export class SidebarComponent  implements OnInit {
  roles: string[] = [];

  constructor(private authService: AuthService) {}

  ngOnInit(): void {
    const token = this.authService.getTokenForGuard();
    if (token) {
      console.log("ya casi: ",token);
      const payload = JSON.parse(atob(token.split('.')[1]));
      this.roles = payload.roles;
    }
  }
}
